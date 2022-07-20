from django import forms
from .models import Photo

# forms.ModelForm : fields 에 정의한 값을 받는 Form 클래스 생성
class PhotoForm(forms.ModelForm):
    class Meta:
        # Model 지정
        model = Photo
        # Model 이 갖는 field 나열
        fields = ("title", "author", "image", "description", "price")
