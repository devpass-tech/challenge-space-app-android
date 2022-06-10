package com.devpass.spaceapp

import com.devpass.spaceapp.data.api.SpaceXAPIService
import com.devpass.spaceapp.data.model.*
import com.devpass.spaceapp.data.repository.launch.LaunchRepository
import com.devpass.spaceapp.data.repository.launch.LaunchRepositoryImpl
import com.devpass.spaceapp.presentation.launch.LaunchActivityViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val service = FakeService()
    private val repository: LaunchRepository = LaunchRepositoryImpl(service)
    private val viewModel = LaunchActivityViewModel(repository)

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun addition_isCorrect() {
        runBlocking {
            //GIVEN
            val event = LaunchActivityViewModel.LaunchEvents.Fetch
            //WHEN
            viewModel.onEvent(event)

            //THEN
            val result = viewModel.state.take(1).toList()
            assertEquals(LaunchActivityViewModel.LaunchState.Loading, result[0])
        }
    }


    class FakeService : SpaceXAPIService {
        companion object {

            var nextLaunches = NextLaunches(
                launches = listOf()
            )
        }

        override suspend fun fetchNextLaunch(): NextLaunchModel {
            TODO("Not yet implemented")
        }

        override suspend fun fetchNextLaunches(params: QueryRequestParams): NextLaunches {
            return nextLaunches
        }

        override suspend fun fetchRocketDetails(rocketId: Int): DRocketDetail {
            TODO("Not yet implemented")
        }
    }

}