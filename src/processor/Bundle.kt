package processor

class Bundle {

    private val hashMap: HashMap<String, Any> = HashMap()

    fun putString(key: String, value: String) {
        putValue(key, value)
    }

    fun getString(key: String, defaultValue: String): String =
            getValue(key) as String? ?: defaultValue

    fun putInt(key: String, value: Int) {
        putValue(key, value)
    }

    fun getInt(key: String, defaultValue: Int): Int =
            getValue(key) as Int? ?: defaultValue 

    fun putBoolean(key: String, value: Boolean) {
        putValue(key, value)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean =
            getValue(key) as Boolean? ?: defaultValue

    fun putDouble(key: String, value: Boolean) {
        putValue(key, value)
    }

    fun getDouble(key: String, defaultValue: Double): Double =
            getValue(key) as Double? ?: defaultValue

    fun putFloat(key: String, value: Float) {
        putValue(key, value)
    }

    fun getFloat(key: String, defaultValue: Float): Float =
            getValue(key) as Float? ?: defaultValue

    fun putLong(key: String, value: Long) {
        putValue(key, value)
    }

    fun getLong(key: String, defaultValue: Long): Long =
            getValue(key) as Long? ?: defaultValue

    fun containsKey(key: String): Boolean = hashMap.containsKey(key)

    private fun putValue(key: String, value: Any) {
        hashMap[key] = value
    }

    private fun getValue(key: String): Any? = hashMap[key]
}