package repository

import repository.dto.DbItem

trait CrudRepository[T <: DbItem] {

  protected var db_collection: List[T]

  def add(apiModel: T): Boolean =  if (db_collection.exists(_.id == apiModel.id)) false else {
    db_collection :+= apiModel
    true
  }

  def find(id: Int): Option[T] = db_collection.find(_.id == id)

  def findAll(): List[T] = db_collection

  def update(apiModel: T): Boolean = if (db_collection.exists(_.id == apiModel.id)) {
    db_collection = db_collection.map(x => if (x.id == apiModel.id) apiModel else x)
    true
  } else false


  def delete(id: Int): Boolean = if (db_collection.exists(_.id == id)) {
    db_collection = db_collection.filterNot(_.id == id)
    true
  } else false
}
