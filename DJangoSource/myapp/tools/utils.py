# HttpRequest
# META : content_length, content_type, http_user_agent ... ( Header 에 따라 붙는 정보 )


def get_client_ip(request):
    x_forwarded_for = request.META.get("HTTP_X_FORWARDED_FOR")

    if x_forwarded_for:
        ip = x_forwarded_for.split(",")[-1].strip()
    else:
        ip = request.META.get("REMOTE_ADDR")

    return ip
