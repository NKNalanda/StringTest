package com.nknalanda.stringtest

class StringStack {
    var recentStrings: ArrayList<String> = ArrayList()
    var olderStrings: ArrayList<String> = ArrayList()

    //To add string into recent stack
    fun addToRecentString(str: String) {
        if (!containsIgnoreCase(recentStrings, str)) {
            if (recentStrings.size == 2) {
                if (containsIgnoreCase(olderStrings, str)) {
                    removeByIgnoringCase(olderStrings, str)
                }
                addToOlderString(recentStrings.last())
                recentStrings.removeLast()
            }
            recentStrings.add(0, str)
        }
    }

    //To add string into older stack
    private fun addToOlderString(str: String) {
        if (olderStrings.size == 3) {
            olderStrings.removeLast()
        }
        olderStrings.add(0, str)
    }

    //To check if ArrayList contains a string by ignoring case
    private fun containsIgnoreCase(list: List<String>, strVal: String): Boolean {
        for (current in list) {
            if (current.equals(strVal, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    //To remove string from ArrayList by ignoring case
    private fun removeByIgnoringCase(list: ArrayList<String>, strVal: String) {
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