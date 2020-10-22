package com.nknalanda.stringtest

object Utils {

    //To check if ArrayList contains a string by ignoring case
    fun containsIgnoreCase(list: List<String>, strVal: String): Boolean {
        for (current in list) {
            if (current.equals(strVal, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    //To remove string from ArrayList by ignoring case
    fun removeByIgnoringCase(list: ArrayList<String>, strVal: String) {
        var selectedIndex = -1
        for (current in list) {
            if (current.equals(strVal, ignoreCase = true)) {
                selectedIndex = list.indexOf(current)
                break
            }
        }
        if (selectedIndex != -1 && (list.size > selectedIndex)) {
            list.removeAt(selectedIndex)
        }

    }
}