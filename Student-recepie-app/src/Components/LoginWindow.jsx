

function LoginForm() {
  return (
    <div class="signUp">
        
          <h2 class="signUptitle" id="loginHeaderRegister" style="margin-bottom: 10px;">SignUp</h2>

          <div class="signUpcontent">
            <div class="signUpbox">
              <div class="signUpbox-input">
                <input
                  type="email"
                  required
                  class="signUpinput"
                  id="username"
                  name="username"
                  placeholder=" "
                />
                <label for="signUp-email" class="signUplabel">Email</label>
              </div>
            </div>

            <div class="signUpbox">
              <div class="signUpbox-input">
                <input
                  type="password"
                  requiredF
                  class="signUpinput"
                  placeholder=""
                  id="password"
                  name="username"
                />
                <label for="signUp-pass" class="signUplabel">Password</label>
              </div>
            </div>
          </div>

          <button type="submit" class="signUpbutton" id="loginBtn">
            Sign Up
          </button>
        
      </div>
  );
}

export default LoginForm;