package com.example.gonggangam.Class

import java.io.Serializable

data class BasicDiary (
    var diaryIdx: Int? = null,
    var emoji: String= "",
    var diaryContent: String? = "",
    var diaryDate: String? = "",
): Serializable