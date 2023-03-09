package com.isansc.genericadapterpoc.model

class SingleItemPacingConfig(item: EdgeItem) : PacingConfig(
    item = item,
    start = 0,
    pacing = 0,
    occurrences = 1
)