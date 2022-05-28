package services

import models.ApiModel
import repository.CrudRepository
import repository.dto.DbItem

abstract class BaseService[T <: ApiModel[Y], Y <: DbItem](repository: CrudRepository[Y]) {

  def findAll(): List[T] = repository.findAll().map(toDomain)

  def find(id: Int): Option[T] = repository.find(id).map(toDomain)

  def add(apiModel: Y): Boolean = repository.add(apiModel)

  def update(apiModel: Y): Boolean = repository.update(apiModel)

  def delete(id: Int): Boolean = repository.delete(id)

  protected def toDomain(dbItem: Y): T
}
