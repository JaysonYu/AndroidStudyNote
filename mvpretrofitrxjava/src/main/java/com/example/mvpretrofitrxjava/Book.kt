package com.example.mvpretrofitrxjava

import java.io.Serializable

/**
 * @author jianxin on 2018/7/17.
 */
class Book : Serializable {

    var count: Int? = null
    var start: Int? = null
    var total: Int? = null
    var books: List<BookBean>? = null

    class BookBean {
        private var subtitle: String? = null
        private var pubdate: String? = null
        private var origin_title: String? = null
        private var image: String? = null
        private var binding: String? = null
        private var catalog: String? = null
        private var pages: String? = null
        private var alt: String? = null
        private var id: String? = null
        private var publisher: String? = null
        private var isbn10: String? = null
        private var isbn13: String? = null
        private var title: String? = null
        private var url: String? = null
        private var alt_title: String? = null
        private var author_intro: String? = null
        private var summary: String? = null
        private var price: String? = null
        private var author: List<String>? = null
        private var translator: List<*>? = null

        override fun toString(): String {
            return "BookBean(subtitle=$subtitle, pubdate=$pubdate, origin_title=$origin_title, image=$image, binding=$binding, catalog=$catalog, pages=$pages, alt=$alt, id=$id, publisher=$publisher, isbn10=$isbn10, isbn13=$isbn13, title=$title, url=$url, alt_title=$alt_title, author_intro=$author_intro, summary=$summary, price=$price, author=$author, translator=$translator)"
        }
    }

    override fun toString(): String {
        return "Book(count=$count, start=$start, total=$total, books=$books)"
    }

}