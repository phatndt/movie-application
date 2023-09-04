package vn.phatndt.model

data class Paging(
    val page: Int? = 0,
    val totalPages: Int? = null,
    val totalResults: Int? = null,
)