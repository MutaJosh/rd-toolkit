package org.rdtoolkit.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.rdtoolkit.model.session.SessionRepository
import org.rdtoolkit.model.session.getDatabase
import org.rdtoolkit.ui.provision.ProvisionViewModel

class InjectorUtils() {
    companion object {
        fun provideProvisionViewModelFactory(context: Context): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return ProvisionViewModel(provideSessionRepository(context)) as T
                }
            }
        }

        fun provideSessionRepository(context: Context) : SessionRepository {
            return SessionRepository(getDatabase(context).testSessionDao())
        }
    }
}