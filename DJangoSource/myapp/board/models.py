from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class Question(models.Model):
    subject = models.CharField(max_length=200)
    content = models.TextField()
    create_date = models.DateTimeField(auto_now_add=True)
    # 작성자 추가
    author = models.ForeignKey(
        User, on_delete=models.CASCADE, related_name="author_question"
    )
    # 수정시간 추가
    modify_date = models.DateTimeField(null=True, blank=True)
    # null=True >> not null : False
    # blank=True >> form.is_valid() 를 통한 유효성 검사 무시

    """
    board.Question.author: (fields.E304) Reverse accessor for 'board.Question.author' clashes with reverse accessor for 'board.Question.voter'.
            HINT: Add or change a related_name argument to the definition for 'board.Question.author' or 'board.Question.voter'.
    board.Question.voter: (fields.E304) Reverse accessor for 'board.Question.voter' clashes with reverse accessor for 'board.Question.author'.
            HINT: Add or change a related_name argument to the definition for 'board.Question.voter' or 'board.Question.author'.

            --> 같은 모덱을 참조하는 경우, 다음과 같은 에러문 발생
                > related_name 속성을 통해 이름을 지정 해줘야 함 ( 관계명 일치 X - Join 시 에러 발생 )
                > .model_set.all / .model_set.count ... 명령어 사용시 Model 지정
                > Question 데이터에 접근할 때 author 필드를 기준으로 할지, voter 필드를 기준으로 할지 지정
    """

    # 추천 수
    voter = models.ManyToManyField(User, related_name="voter_question")
    # ManyToManyField() : M : N 관계
    def __str__(self) -> str:
        return self.subject + " " + self.content


class Answer(models.Model):
    # Answer - Question 테이블 간의 외래키 제약조건 성립
    # on_delete : CASCADA 여부
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    content = models.TextField()
    create_date = models.DateTimeField(auto_now_add=True)
    # 작성자 추가
    author = models.ForeignKey(User, on_delete=models.CASCADE, related_name="author_answer")
    # 수정 시간 추가
    modify_date = models.DateTimeField(null=True, blank=True)

    voter = models.ManyToManyField(User, related_name="voter_answer")
    
    def __str__(self) -> str:
        return str(self.question) + " " + self.content


# 댓글 모델
class Comment(models.Model):
    # 댓글 작성자 ( user 테이블 정보 사용 )
    author = models.ForeignKey(User, on_delete=models.CASCADE)
    # 댓글 내용 => form 에서 데이터 입력
    content = models.TextField()
    # 댓글 작성 날짜
    create_date = models.DateTimeField(auto_now_add=True)
    # 댓글 수정 날짜
    modify_date = models.DateTimeField(null=True, blank=True)
    # 질문
    question = models.ForeignKey(
        Question, on_delete=models.CASCADE, null=True, blank=True
    )
    # 답변
    answer = models.ForeignKey(Answer, on_delete=models.CASCADE, null=True, blank=True)
