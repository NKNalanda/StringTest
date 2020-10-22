package com.nknalanda.stringtest

class StringStack {
    var recentStrings: ArrayList<String> = ArrayList()
    var olderStrings: ArrayList<String> = ArrayList()

    //To add string into recent stack
    fun addToRecentString(str: String) {
        if (!Utils.containsIgnoreCase(recentStrings, str)) {
            if (recentStrings.size == 2) {
                if (Utils.containsIgnoreCase(olderStrings, str)) {
                    Utils.removeByIgnoringCase(olderStrings, str)
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
}