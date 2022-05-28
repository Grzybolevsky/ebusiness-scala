package repository

import repository.dto.DbItem

trait CrudRepository[T <: DbItem] {

  protected var db_collection: List[T]

  def add(dbItem: T): Boolean = if (db_collection.exists(_.id == dbItem.id)) false else {
    db_collection :+= dbItem
    true
  }

  def find(id: Int): Option[T] = db_collection.find(_.id == id)

  def findAll(): List[T] = db_collection

  def update(dbItem: T): Boolean = if (db_collection.exists(_.id == dbItem.id)) {
    db_collection = db_collection.map(x => if (x.id == dbItem.id) dbItem else x)
    true
  } else false


  def delete(id: Int): Boolean = if (db_collection.exists(_.id == id)) {
    db_collection = db_collection.filterNot(_.id == id)
    true
  } else false
}
