package services

import models.ApiModel
import repository.CrudRepository
import repository.dto.DbItem

abstract class BaseService[T <: ApiModel[Y], Y <: DbItem](repository: CrudRepository[Y]) {

  def findAll(): List[T] = repository.findAll().map(toDomain)

  def find(id: Int): Option[T] = repository.find(id).map(toDomain)

  def add(apiModel: T): Boolean = repository.add(apiModel.toDbItem)

  def update(apiModel: T): Boolean = repository.update(apiModel.toDbItem)

  def delete(id: Int): Boolean = repository.delete(id)

  protected def toDomain(dbItem: Y): T
}
