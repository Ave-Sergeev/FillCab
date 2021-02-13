package com.example.FillCab.services

/**
 * Реализация базового сервиса, для расширения конкретными сервисами.
 */

interface IBaseService<T> {
    //Найти все объекты
    fun findAll(): Iterable<T>

    //Сохранить объект
    fun save(card: T)

    //Удалить объект
    fun delete(card: T)

    //Удалить объект c определенным id
    fun deleteById(id: Long)
}