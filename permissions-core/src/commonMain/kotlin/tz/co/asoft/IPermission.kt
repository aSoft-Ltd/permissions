package tz.co.asoft

interface IPermission {
    val title: String
    val details: String
    val needs: List<String>
}
