package com.example.FillCab.controllers

import com.example.FillCab.models.PersonalCard
import com.example.FillCab.services.PersonalServiceImpl
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SearchController (val personalServiceImpl: PersonalServiceImpl) {

    //Отдаем страницу Поиска работника
    @GetMapping("/searchPersonPage{surname}")
    fun searchPersonShow(@RequestParam(value = "surname", required = false) surname: String,
                         model: MutableMap<String, Any?>): String {
        val allSearchName: Iterable<PersonalCard> = personalServiceImpl.findBySurnameIgnoreCase(surname)
        model["personsList"] = allSearchName
        model["surname"] = surname

        return "searchPersonPage"
    }
}
