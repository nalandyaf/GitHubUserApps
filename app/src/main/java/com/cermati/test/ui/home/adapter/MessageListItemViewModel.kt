package com.github.apps.ui.home.adapter

import androidx.databinding.ObservableField
import com.cermati.test.databinding.ItemUserBinding
import com.cermati.test.domain.models.User
import java.util.*

class UserListItemViewModel(
    itemData: User?, var actionDetail: (User, ItemUserBinding) -> Unit,
    var binding: ItemUserBinding
) : Observable() {

    val imageUrl = ObservableField<String>("")
    val name = ObservableField<String>()

    var data: User? = itemData

    init {
        imageUrl.set(data?.avatar)
        name.set(data?.name)
    }

    fun goDetail() {
        with(binding) {
            executePendingBindings()
        }
        actionDetail(data!!, binding)
    }

}