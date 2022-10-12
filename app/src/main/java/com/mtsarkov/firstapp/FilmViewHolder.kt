package com.mtsarkov.firstapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.film_item.view.*

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем View из layout к переменным
    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description
    private val ratingDonut = itemView.rating_donut

    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title.toString()
        //Устанавливаем постер
        Glide.with(itemView)
            .load(film.poster)
            .centerCrop()
            .into(poster)
        //Устанавливаем описание
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())
    }
}