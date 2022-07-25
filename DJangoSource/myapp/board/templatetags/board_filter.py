from django import template

register = template.Library()


@register.filter
def sub(value, arg):
    return value - arg


# 템플릿 필터
# 템플릿 태그에서 | 문자 뒤에 사용하는 필터
# ex ) {{ form.subject.value | default_if_none:'' }}

# 게시물 번호
# 일련번호 : 전체 게시물 개수 - 시작 인덱스 - 현재 인덱스 + 1
# 페이지당 게시물을 10건씩 보여줄 때 시작 인덱스 : 1, 11, 21, 31...
# 페이지당 게시물을 10건씩 보여줄 때 현재 인덱스 : 0 ~ 9 반복
