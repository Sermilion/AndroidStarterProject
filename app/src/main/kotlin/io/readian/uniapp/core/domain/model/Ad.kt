package io.readian.uniapp.core.domain.model

import java.util.UUID

data class Ad(
  val name: String,
  val price: String,
  val description: String,
  val image: String,
  val category: String,
  val selected: Boolean = true,
  val id: UUID,
)
