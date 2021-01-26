package com.example.telephoneTry.controllers

import com.example.telephoneTry.models.PersonalCard
import com.example.telephoneTry.services.DepartmentServiceImpl
import com.example.telephoneTry.services.PersonalServiceImpl
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SearchController (val personalServiceImpl: PersonalServiceImpl) {

    //Отдаем страницу Поиска работника
    @GetMapping("/searchPersonPage{name}")
    fun searchPersonShow(@RequestParam(value = "name", required = false) name: String,
                         model: MutableMap<String, Any?>): String {
        val allSearchName: Iterable<PersonalCard> = personalServiceImpl.findByNameIgnoreCase(name)
        model["personsList"] = allSearchName
        model["name"] = name
        return "searchPersonPage"
    }
}