package com.example.telephoneTry.models

import javax.persistence.*

@Entity
class PersonalCard(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1,

    val name: String = "",
    val surname: String = "",
    val patronymic: String = "",
    val mobilePhone: String = "",
    val position: String = "",

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "dep_id", nullable = true)
    var department: DepartmentCard? = null
) {
    override fun toString(): String {
        return "id:$id, name:$name, surname:$surname, patronymic:$patronymic, " +
                "mobilePhone:$mobilePhone position:$position, department:${department?.name}"
    }
}
