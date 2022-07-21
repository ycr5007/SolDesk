from django.http import HttpResponse
from django.shortcuts import get_object_or_404, redirect, render

from .models import Todo
from .forms import TodoForm

# Create your views here.


def todo_list(request):
    # return HttpResponse("To Do ... App")
    # lists = Todo.objects.all()
    lists = Todo.objects.filter(completed=False)
    return render(request, "todo/todo_list.html", {"lists": lists})


def todo_detail(request, pk):

    # todo = get_object_or_404(Todo, pk=pk)

    todo = Todo.objects.get(id=pk)
    return render(request, "todo/todo_detail.html", {"todo": todo})


def todo_register(request):

    if request.method == "POST":
        form = TodoForm(request.POST)
        if form.is_valid():
            todo = form.save(commit=False)
            todo.save()
            return redirect("todo_list")
    else:
        form = TodoForm()
    return render(request, "todo/todo_register.html", {"form": form})


def todo_edit(request, pk):
    data = get_object_or_404(Todo, pk=pk)
    if request.method == "POST":
        form = TodoForm(request.POST, instance=data)
        if form.is_valid():
            todo = form.save(commit=False)
            todo.save()
            return redirect("todo_detail", pk=pk)
    else:
        form = TodoForm(instance=data)
    return render(request, "todo/todo_register.html", {"form": form})


def todo_done(request, pk):
    data = get_object_or_404(Todo, pk=pk)
    data.completed = True
    data.save()
    return redirect("todo_list")


def done_list(request):
    lists = Todo.objects.filter(completed=True)
    return render(request, "todo/done_list.html", {"lists": lists})
