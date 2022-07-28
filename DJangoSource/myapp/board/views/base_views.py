from django.shortcuts import get_object_or_404, render
from django.core.paginator import Paginator
from django.db.models import Q, Count

from ..models import Question, QuestionCount
from tools.utils import get_client_ip


def index(request):
    """
    게시물 리스트
    """
    # q_list = Question.objects.all()

    page = request.GET.get("page", 1)  # http://127.0.0.1:8000/board/?page=1
    keyword = request.GET.get("keyword", "")
    sort = request.GET.get("sort", "recent")

    if sort == "recent":
        # 최신순으로 정렬
        q_list = Question.objects.order_by("-create_date")
    elif sort == "recommend":
        # 추천순으로 정렬
        # num_voter 라는 임시 Field 생성 ( Count 함수를 통해 개수필드 )
        q_list = Question.objects.annotate(num_voter=Count("voter")).order_by(
            "-num_voter", "-create_date"
        )
    elif sort == "popular":
        # 인기순으로 정렬 ( 답변이 많은 순서 )
        q_list = Question.objects.annotate(num_answer=Count("answer")).order_by(
            "-num_answer", "-create_date"
        )

    # 조회된 목록을 기준으로 검색 조건 부여 ( filtering )
    # Q() : OR 조건으로 데이터 조회하는 DJango 함수
    if keyword:
        q_list = q_list.filter(
            Q(subject__icontains=keyword)
            | Q(content__icontains=keyword)
            | Q(author__username__icontains=keyword)
            | Q(answer__author__username__icontains=keyword)
        ).distinct()

    paginator = Paginator(q_list, 10)  # Paginator 객체 생성 : Paginator(전체 리스트, amount)
    page_obj = paginator.get_page(page)

    context = {
        "question_list": page_obj,
        "page": page,
        "keyword": keyword,
        "sort": sort,
    }
    return render(request, "board/question_list.html", context)


def detail(request, question_id):
    """
    게시물 상세
    """
    # 없는 ID 를 요청했을 때 웹 페이지에 오류 메세지가 그대로 출력
    # q = Question.objects.get(id=question_id)
    q = get_object_or_404(Question, pk=question_id)

    # 조회수 처리
    # 사용자 IP 가져오기
    ip = get_client_ip(request)
    # 찾은 IP가 QuestionCount 테이블 내 데이터 여부 확인
    cnt = QuestionCount.objects.filter(ip=ip, question=q).count()

    if cnt == 0:
        QuestionCount(ip=ip, question=q).save()
        q.hit += 1
        q.save()
        
    context = {
        "question": q,
        "page": request.GET.get("page", "1"),
        "keyword": request.GET.get("keyword", ""),
        "sort": request.GET.get("sort", "recent"),
    }
    return render(request, "board/question_detail.html", context)
