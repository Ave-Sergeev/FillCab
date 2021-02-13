package com.example.FillCab.models

import javax.persistence.*
import javax.persistence.PreRemove

/**
 * Класс DepartmentCard, хранится в базе
 * Для правильного удаления дочерних элементов при удалении родителя добавлен PreRemove,
 * иначе поле удаляется.
 */

@Entity
class DepartmentCard (
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id: Long = -1,

    var name: String = "",

    @OneToMany(mappedBy = "department", fetch=FetchType.LAZY)
    val persons: Set<PersonalCard> = hashSetOf()
) {
    override fun toString(): String {
        return "id:$id, name:$name, persons:${persons.map { it.toString() }}"
    }

    @PreRemove
    fun removeAssociationsWithChildren() = persons.forEach { it.department = null }
}