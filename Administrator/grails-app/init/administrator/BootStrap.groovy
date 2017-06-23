package administrator

import com.admin.Role
import com.admin.User
import com.admin.UserRole

class BootStrap {

        def init = {

            def adminRole = new Role(authority: 'ROLE_ADMIN').save()

            def testUser = new User(username: 'root', password: 'pass').save()

            UserRole.create testUser, adminRole

            UserRole.withSession {
                it.flush()
                it.clear()
            }

            assert User.count() == 1
            assert Role.count() == 1
            assert UserRole.count() == 1

        }

    def destroy = {
    }
}
