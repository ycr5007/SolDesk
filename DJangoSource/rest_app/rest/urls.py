from django.urls import path
from .views import *
from rest_framework import routers

# urlpatterns = [
#     path("hello/", HelloAPI),
#     # 함수형 View
#     path("books/", booksAPI),
#     path("books/<int:bid>", bookAPI),
#     # Class View
#     path("cv/books/", BooksAPI.as_view()),
#     path("cv/books/<int:bid>", BookAPI.as_view()),
#     # mixins View
#     path("mixin/books/", BooksAPIMixins.as_view()),
#     path("mixin/books/<int:bid>", BookAPIMixins.as_view()),
#     # generics View
#     path("gen/books/", BooksAPIGenerics.as_view()),
#     path("gen/books/<int:bid>", BookAPIGenerics.as_view()),
# ]


#################### DRF Viewset & Router ####################

router = routers.SimpleRouter()
router.register("books", BookViewSet)
urlpatterns = router.urls
