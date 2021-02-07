package com.lucky.smartclinic.model.item

import android.content.Context
import com.lucky.smartclinic.R
import com.lucky.smartclinic.application.GlideApp
import com.lucky.smartclinic.model.Article
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.news_item_view.*

class NewsItem (val context: Context,  val newsArticle: Article):Item()
{
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        GlideApp.with(context).load(newsArticle.urlToImage).placeholder(R.drawable.ic_baseline_person_pin_24).into(viewHolder.iv_news)
        viewHolder.tv_news_title.text = newsArticle.title
        viewHolder.tv_news_description.text =  newsArticle.description
        viewHolder.tv_news_source.text = newsArticle.source.name
    }

    override fun getLayout() = R.layout.news_item_view

}