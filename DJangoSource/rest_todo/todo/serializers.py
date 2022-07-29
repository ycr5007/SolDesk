# Serializers : 직렬화 ↔ 역직렬화 담당

from rest_framework import serializers
from .models import Todo


# 전체조회 Serializer
class TodoSimpleSerializer(serializers.ModelSerializer):
    class Meta:
        model = Todo
        fields = ("id", "title", "complete", "important")


# 상세조회 Serializer
class TodoDetailSerializer(serializers.ModelSerializer):
    class Meta:
        model = Todo
        fields = ("id", "title", "description", "created", "complete", "important")


# 생성 Serializer
class TodoCreateSerializer(serializers.ModelSerializer):
    class Meta:
        model = Todo
        fields = ("title", "description", "important")


# Todo 완료 Serializer
