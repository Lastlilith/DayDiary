package com.imnidasoftware.daydiary.presentation.screens.write

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.imnidasoftware.daydiary.model.Diary
import com.imnidasoftware.daydiary.model.GalleryState
import com.imnidasoftware.daydiary.model.Mood
import java.time.ZonedDateTime

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WriteScreen(
    uiState: UiState,
    moodName: () -> String,
    pagerState: PagerState,
    galleryState: GalleryState,
    onSaveClicked: (Diary) -> Unit,
    onTitleChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit,
    onDeleteConfirmed: () -> Unit,
    onBackPressed: () -> Unit,
    onDateTimeUpdated: (ZonedDateTime) -> Unit,
    onImageSelect: (Uri) -> Unit
) {
    LaunchedEffect(key1 = uiState.mood) {
        pagerState.scrollToPage(Mood.valueOf(uiState.mood.name).ordinal)
    }
    Scaffold(
        topBar = {
            WriteTopBar(
                selectedDiary = uiState.selectedDiary,
                moodName = moodName,
                onDeleteConfirmed = onDeleteConfirmed,
                onBackPressed = onBackPressed,
                onDateTimeUpdated = onDateTimeUpdated
            )
        },
        content = {
            WriteContent(
                uiState = uiState,
                pagerState = pagerState,
                title = uiState.title,
                galleryState = galleryState,
                onTitleChanged = onTitleChanged,
                description = uiState.description,
                onDescriptionChanged = onDescriptionChanged,
                paddingValues = it,
                onSaveClicked = onSaveClicked,
                onImageSelect = onImageSelect
            )
        }
    )
}