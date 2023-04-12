package com.nabil.banglaclock

class TimeTranslator {

    companion object{
        private val digitMap = HashMap<Char, String>()

        fun translate(input : String) : String{
            if (digitMap.isEmpty()){
                for (i in 0..9) {
                    digitMap[i.toString()[0]] = "০১২৩৪৫৬৭৮৯"[i].toString()
                }
            }

            var finalText = ""
            for (char in input) {
                finalText += digitMap[char] ?: char
            }

            return finalText
        }
    }
}