package models

import repository.dto.DbItem

trait ApiModel[U <: DbItem] {
  val id: Int

  def toDbItem: U
}
