package com.example.fragmentsviewpager

interface ArticleFilter {
    fun filterArticles(tags: List<ArticleType>)
}