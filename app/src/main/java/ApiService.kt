import android.media.session.MediaSession
import com.example.esg.Exercise
import com.example.esg.LoginInfo
import com.example.esg.Token
import com.example.esg.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/users")
    fun getUsers(): Call<List<User>>

    @POST("/users")
    fun createUser(@Body user: User): Call<User>

    @POST("/login")
    fun loginUser(@Body loginInfo: LoginInfo): Call<Token>

    @GET("/me")
    fun getCurrentUser(): Call<User>

    @GET("/users/exercises")
    fun getUserExercises(): Call<List<Exercise>>

    @POST("/exercise")
    fun createExercise(@Body exercise: Exercise): Call<Exercise>
}