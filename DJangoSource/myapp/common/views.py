from django.shortcuts import redirect, render
from .forms import UserForm
from django.contrib.auth import authenticate, login


# Create your views here.


def signup(request):

    """
    회원가입
    """
    if request.method == "POST":
        form = UserForm(request.POST)
        if form.is_valid():
            # DJango 에서 제공하는 Form 이기 때문에 form.save() 명령어를 통해 DB 저장 가능
            form.save()  # DB 저장

            # form.save() : Default Commit True
            # form.save(commit=False) : DB 반영 전 추가 값 입력 시 사용
            # form.save() : 추가 입력 사항이 없을 시 사용

            # return redirect("common:login")

            # Jango 에서 제공하는 방식 : 사용자가 입력한 값으로 로그인

            # form.cleaned_data.get() : 넘어온 폼에서 화면의 입력값을 얻기 위한 함수
            username = form.cleaned_data.get("username")
            raw_password = form.cleaned_data.get("password1")

            # authenticate(username=, password=) : 사용자의 아이디와 비밀번호를 담아 자격증명을 요청하는 함수
            user = authenticate(username=username, password=raw_password)

            if user is not None:
                # login() : 실제 로그인을 해주는 함수
                login(request, user)
            return redirect("/")
    else:
        form = UserForm()
    return render(request, "common/signup.html", {"form": form})
