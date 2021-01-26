package com.example.FillCab.models

import javax.persistence.*
import javax.persistence.PreRemove

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