# pip install tmdbv3api : tmdb5000 영화 상세정보를 얻어오기 위한 라이브러리 설치
# pip install streamlit : 간단한 웹 어플리케이션을 만들어주는 라이브러리
import pickle
from webbrowser import get
import streamlit as st
from tmdbv3api import Movie, TMDb

url = "https://api.themoviedb.org/3/movie/550?api_key="

movie = Movie()
tmdb = TMDb()
tmdb.api_key = "329efec0f6e7aa83f360fdf5c46d8e87"

# 영화 데이터와 코사인 유사도 불러오기
movies = pickle.load(open("movies.pickle", "rb"))
cosine_sm = pickle.load(open("cosine_sm2.pickle", "rb"))

# 화면구현
st.set_page_config(layout="wide")

# 제목
st.header("Myflix")

# 영화 전체 목록 보여주기
movie_list = movies["title"].values
title = st.selectbox("Choose a movie you like", movie_list)


def get_recommendations(title):
    # 타이틀을 통해 인덱스 얻어오기
    idx = movies[movies["title"] == title].index[0]
    # idx 를 통해 코사인 유사도 매트릭스에서 (idx, 유사도) 가져오기
    sim_scores = list(enumerate(cosine_sm[idx]))
    # 정렬
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:11]
    # 10개의 영화 인덱스 추출
    movie_indicies = [i[0] for i in sim_scores]
    # 10개의 영화 제목, 이미지 추출
    images, titles = [], []
    for i in movie_indicies:
        # 영화 id 가져오기
        id = movies["id"].iloc[i]
        # 영화 상세정보 가져오기
        details = movie.details(id)

        # 포스터가 없는경우 ( image )
        image_path = details["poster_path"]

        if image_path:
            image_path = "https://image.tmdb.org/t/p/w500" + image_path
        else:
            image_path = "no-image.png"
        images.append(image_path)
        titles.append(details["title"])
    return images, titles


if st.button("Recommand"):

    with st.spinner("Please wait ... "):
        images, titles = get_recommendations(title)

        idx = 0

        for i in range(0, 2):
            # 5 개 컬럼 생성
            cols = st.columns(5)

            for col in cols:
                col.image(images[idx])
                col.write(titles[idx])
                idx += 1

# streamlit run app.py :: 실행 방법
