from django.shortcuts import get_object_or_404
from rest_framework.response import Response
from rest_framework.decorators import api_view
from rest_framework import status
from rest_framework.views import APIView
from rest_framework import mixins, generics
from rest_framework import viewsets

from .serializers import BookSerializer
from .models import Book


# Create your views here.
@api_view(["GET"])
def HelloAPI(request):
    # 	AssertionError : .accepted_renderer not set on Response > rest Response 기 때문에 페이지로서 인식 X
    return Response("hello World")


#################### 함수형 View ####################
# 장고 개발 시 사용했던 개념


@api_view(["GET", "POST"])
def booksAPI(request):
    if request.method == "GET":
        # book 테이블의 모든 책 정보를 가져오기
        book_list = Book.objects.all()
        # └ 객체 ─────────> JSON
        # serializer 에 전체 데이터 한번에 넣기
        serializer = BookSerializer(book_list, many=True)

        return Response(serializer.data, status=status.HTTP_200_OK)
    elif request.method == "POST":
        # JSON ─────────> 객체
        serializer = BookSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(["GET"])
def bookAPI(request, bid):
    if request.method == "GET":
        book = get_object_or_404(Book, pk=bid)
        serializer = BookSerializer(book)
        return Response(serializer.data, status=status.HTTP_200_OK)


#################### 클래스 View ####################
# 함수형 View 와 하는 일이 같음 ( 형식의 차이 )
# 클래스 내에 get 과 post 를 따로 함수로 정의


class BooksAPI(APIView):
    def get(self, request):
        book_list = Book.objects.all()
        serializer = BookSerializer(book_list, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = BookSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class BookAPI(APIView):
    def get(self, request, bid):
        book = get_object_or_404(Book, pk=bid)
        serializer = BookSerializer(book)
        return Response(serializer.data, status=status.HTTP_200_OK)


#################### DRF mixins ####################
# ListModelMixin        : getAll    > list
# RetrieveModelMixin    : getOne    > retrieve
# CreateModelMixin      : Create    > create
# UpdateModelMixin      : Update    > update
# DestroyModelMixin     : Delete    > destroy


class BooksAPIMixins(
    mixins.ListModelMixin, mixins.CreateModelMixin, generics.GenericAPIView
):
    queryset = Book.objects.all()
    serializer_class = BookSerializer

    def get(self, request, *args, **kwargs):
        return self.list(request, *args, **kwargs)

    def post(self, request, *args, **kwargs):
        return self.create(request, *args, **kwargs)


class BookAPIMixins(
    mixins.RetrieveModelMixin,
    mixins.UpdateModelMixin,
    mixins.DestroyModelMixin,
    generics.GenericAPIView,
):
    queryset = Book.objects.all()
    serializer_class = BookSerializer
    lookup_field = "bid"  # pk Field

    def get(self, request, *args, **kwargs):
        return self.retrieve(request, *args, **kwargs)

    def put(self, request, *args, **kwargs):
        return self.update(request, *args, **kwargs)

    def delete(self, request, *args, **kwargs):
        return self.destroy(request, *args, **kwargs)


#################### DRF generics ####################


class BooksAPIGenerics(generics.ListCreateAPIView):
    queryset = Book.objects.all()
    serializer_class = BookSerializer


class BookAPIGenerics(generics.RetrieveUpdateDestroyAPIView):
    queryset = Book.objects.all()
    serializer_class = BookSerializer
    lookup_field = "bid"


#################### DRF Viewset & Router ####################
# ViewSet : View 의 집합 ( 여러거지 뷰를 한 곳에 모아놓음 )


class BookViewSet(viewsets.ModelViewSet):
    queryset = Book.objects.all()
    serializer_class = BookSerializer
