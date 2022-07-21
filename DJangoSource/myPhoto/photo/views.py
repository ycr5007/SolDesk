from webbrowser import get
from django.shortcuts import get_object_or_404, redirect, render
from django.http import HttpResponse

from .forms import PhotoForm
from .models import Photo

# Create your views here.

# urls 에서 지정하는 함수
def photo_list(request):
    # 텍스트 띄우기
    # return HttpResponse("Hello Photo")

    # 특정 templates 보여주기
    # render() : 특정 template 파일을 이용해 views 를 지정하고
    #            데이터베이스 내용을 보낼 수 있음

    # Photo.objects.all() :  Photo 테이블 내용 전체 조회
    photos = Photo.objects.all()

    return render(request, "photo/photo_list.html", {"photos": photos})


def photo_detail(request, pk):
    # pk 에 해당하는 데이터를 찾으며, 없을 시 404 에러 발생
    photo = get_object_or_404(Photo, pk=pk)
    return render(request, "photo/photo_detail.html", {"photo": photo})


def photo_post(request):
    # request 에 대한 method 를 Mapping 으로 지정할 수 없기 때문에 조건문으로 분기한다.
    if request.method == "POST":  # POST
        form = PhotoForm(request.POST)
        if form.is_valid():
            photo = form.save(commit=False)
            photo.save()  # DB Insert 작업
            # redirect("URL Name") : URL Name 이 일치하는 주소로 Redirect
            return redirect("photo_detail", pk=photo.pk)
    else:  # GET
        form = PhotoForm()

    return render(request, "photo/photo_post.html", {"form": form})


def photo_edit(request, pk):
    # pk 에 해당하는 내용 찾아오기
    photo = get_object_or_404(Photo, pk=pk)

    if request.method == "POST":
        form = PhotoForm(request.POST, instance=photo)
        if form.is_valid():
            photo = form.save(commit=False)
            photo.save()  # DB 내에 값이 있기 때문에, 값에 대해 DB Update 작업
            return redirect("photo_detail", pk=photo.pk)
    else:
        form = PhotoForm(instance=photo)
    return render(request, "photo/photo_post.html", {"form": form})


def photo_remove(request, pk):
    # pk 에 해당하는 데이터 찾기
    photo = get_object_or_404(Photo, pk=pk)
    # 삭제
    photo.delete()
    # DB 작업 후 이동할 경로
    return redirect("photo_list")
