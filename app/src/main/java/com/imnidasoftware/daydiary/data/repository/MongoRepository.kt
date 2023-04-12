package com.imnidasoftware.daydiary.data.repository

import com.imnidasoftware.daydiary.model.Diary
import com.imnidasoftware.daydiary.util.RequestState
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

typealias Diaries = RequestState<Map<LocalDate, List<Diary>>>

interface MongoRepository {
    fun configureTheRealm()
    fun getAllDiaries(): Flow<Diaries>
}