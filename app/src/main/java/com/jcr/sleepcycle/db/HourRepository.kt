package com.jcr.sleepcycle.db

class HourRepository(private val dao: HourDao) {
    val hours = dao.getAllHours()

    suspend fun insert(hour: Hour) {
        dao.insertHour(hour)
    }

    suspend fun delete(hour: Hour) {
        dao.deleteHour(hour)
    }

    suspend fun update(hour: Hour){
        dao.updateHour(hour)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}