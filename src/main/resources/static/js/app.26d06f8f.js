(function(e){function r(r){for(var s,o,i=r[0],m=r[1],l=r[2],c=0,d=[];c<i.length;c++)o=i[c],a[o]&&d.push(a[o][0]),a[o]=0;for(s in m)Object.prototype.hasOwnProperty.call(m,s)&&(e[s]=m[s]);u&&u(r);while(d.length)d.shift()();return n.push.apply(n,l||[]),t()}function t(){for(var e,r=0;r<n.length;r++){for(var t=n[r],s=!0,i=1;i<t.length;i++){var m=t[i];0!==a[m]&&(s=!1)}s&&(n.splice(r--,1),e=o(o.s=t[0]))}return e}var s={},a={app:0},n=[];function o(r){if(s[r])return s[r].exports;var t=s[r]={i:r,l:!1,exports:{}};return e[r].call(t.exports,t,t.exports,o),t.l=!0,t.exports}o.m=e,o.c=s,o.d=function(e,r,t){o.o(e,r)||Object.defineProperty(e,r,{enumerable:!0,get:t})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,r){if(1&r&&(e=o(e)),8&r)return e;if(4&r&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(o.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&r&&"string"!=typeof e)for(var s in e)o.d(t,s,function(r){return e[r]}.bind(null,s));return t},o.n=function(e){var r=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(r,"a",r),r},o.o=function(e,r){return Object.prototype.hasOwnProperty.call(e,r)},o.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],m=i.push.bind(i);i.push=r,i=i.slice();for(var l=0;l<i.length;l++)r(i[l]);var u=m;n.push(["56d7","chunk-vendors"]),t()})({"30eb":function(e,r,t){},"4b25":function(e,r,t){"use strict";var s=t("ef76"),a=t.n(s);a.a},"56d7":function(e,r,t){"use strict";t.r(r);t("cadf"),t("551c"),t("f751"),t("097d");var s=t("2b0e"),a=function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},n=[],o={name:"App"},i=o,m=(t("5c0b"),t("2877")),l=Object(m["a"])(i,a,n,!1,null,null,null),u=l.exports,c=t("8c4f"),d=function(){var e=this,r=e.$createElement;e._self._c;return e._m(0)},f=[function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",[t("h1",{staticClass:"page-title"},[e._v("Home Page")])])}],v={name:"HomePage"},p=v,g=Object(m["a"])(p,d,f,!1,null,null,null),h=g.exports,_=function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"container public"},[t("div",{staticClass:"row justify-content-center"},[t("div",{staticClass:"form"},[t("Logo"),t("form",{on:{submit:function(r){return r.preventDefault(),e.submitForm(r)}}},[t("div",{directives:[{name:"show",rawName:"v-show",value:e.errorMessage,expression:"errorMessage"}],staticClass:"alert alert-danger failed"},[e._v(e._s(e.errorMessage))]),t("div",{staticClass:"form-group"},[t("label",{attrs:{for:"username"}},[e._v("Username or email address")]),t("input",{directives:[{name:"model",rawName:"v-model",value:e.form.username,expression:"form.username"}],staticClass:"form-control",attrs:{type:"text",id:"username"},domProps:{value:e.form.username},on:{input:function(r){r.target.composing||e.$set(e.form,"username",r.target.value)}}}),e.$v.form.username.$dirty?t("div",{staticClass:"field-error"},[e.$v.form.username.required?e._e():t("div",{staticClass:"error"},[e._v("Username or email address is required")])]):e._e()]),t("div",{staticClass:"form-group"},[t("label",{attrs:{for:"password"}},[e._v("Password")]),t("input",{directives:[{name:"model",rawName:"v-model",value:e.form.password,expression:"form.password"}],staticClass:"form-control",attrs:{type:"password",id:"password"},domProps:{value:e.form.password},on:{input:function(r){r.target.composing||e.$set(e.form,"password",r.target.value)}}}),e.$v.form.password.$dirty?t("div",{staticClass:"field-error"},[e.$v.form.password.required?e._e():t("div",{staticClass:"error"},[e._v("Password is required")])]):e._e()]),t("button",{staticClass:"btn btn-primary btn-block",attrs:{type:"submit"}},[e._v("Sign in")]),e._m(0)])],1)]),t("PageFooter")],1)},b=[function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"links"},[t("p",{staticClass:"sign-up text-muted"},[e._v("\n            Don't have an account yet?\n            "),t("a",{staticClass:"link-sign-up",attrs:{href:"/register"}},[e._v("Sign up here")])]),t("p",[t("a",{attrs:{href:"#"}},[e._v("Forgot your password?")])])])}],w=t("b5ae"),$=t("bc3a"),C=t.n($),y=t("2ef0"),x=t.n(y),P={parse:function(e){if(e.response){var r=e.response.status,t=e.response.data;return 400===r?t&&t.message?new Error(t.message):new Error("Bad request"):401===r?new Error("Request not authorized."):403===r?new Error("Request forbidden."):404===r?new Error("Request failed. Request endpoint not found on the server."):500===r?t&&t.message?new Error(t.message+" Please try again later."):new Error("There is an error on the server side. Please try again later."):new Error("Request failed. Please try again later.")}return e.request?new Error("Request failed. No response from the server."):x.a.isError(e)?e:new Error(e)}},q={authenticate:function(e){return new Promise(function(r,t){C.a.post("/authentications",e).then(function(e){var t=e.data;r(t)}).catch(function(e){t(P.parse(e))})})}},L=function(){var e=this,r=e.$createElement;e._self._c;return e._m(0)},E=[function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"logo-wrapper"},[t("img",{staticClass:"logo",attrs:{src:"/static/images/logo.png"}}),t("div",{staticClass:"tagline"},[e._v("Open source task management tool")])])}],j={name:"Logo"},O=j,A=(t("4b25"),Object(m["a"])(O,L,E,!1,null,"bd38859a",null)),M=A.exports,k=function(){var e=this,r=e.$createElement;e._self._c;return e._m(0)},F=[function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("footer",{staticClass:"footer"},[t("span",{staticClass:"copyright"},[e._v("© 2019 TaskManager.com")]),t("ul",{staticClass:"footer-links list-inline float-right"},[t("li",{staticClass:"list-inline-item"},[t("a",{attrs:{href:"#"}},[e._v("About")])]),t("li",{staticClass:"list-inline-item"},[t("a",{attrs:{href:"#"}},[e._v("Terms of Service")])]),t("li",{staticClass:"list-inline-item"},[t("a",{attrs:{href:"#"}},[e._v("Privacy Policy")])]),t("li",{staticClass:"list-inline-item"},[t("a",{attrs:{href:"https://github.com/UmmmUsername/TaskManager",target:"_blank"}},[e._v("GitHub")])])])])}],N={name:"PageFooter"},S=N,U=(t("c556"),Object(m["a"])(S,k,F,!1,null,"37bf5e2c",null)),R=U.exports,T={name:"LoginPage",data:function(){return{form:{username:"",password:""},errorMessage:""}},components:{Logo:M,PageFooter:R},validations:{form:{username:{required:w["required"]},password:{required:w["required"]}}},methods:{submitForm:function(){var e=this;this.$v.$touch(),this.$v.$invalid||q.authenticate(this.form).then(function(){e.$router.push({name:"home"})}).catch(function(r){e.errorMessage=r.message})}}},I=T,D=(t("8911"),Object(m["a"])(I,_,b,!1,null,"457e409e",null)),H=D.exports,B=function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"container public"},[t("div",{staticClass:"row justify-content-center"},[t("div",{staticClass:"form"},[t("Logo"),t("form",{on:{submit:function(r){return r.preventDefault(),e.submitForm(r)}}},[t("div",{directives:[{name:"show",rawName:"v-show",value:e.errorMessage,expression:"errorMessage"}],staticClass:"alert alert-danger failed"},[e._v(e._s(e.errorMessage))]),t("div",{staticClass:"form-group"},[t("label",{attrs:{for:"username"}},[e._v("Username")]),t("input",{directives:[{name:"model",rawName:"v-model",value:e.form.username,expression:"form.username"}],staticClass:"form-control",attrs:{type:"text",id:"username"},domProps:{value:e.form.username},on:{input:function(r){r.target.composing||e.$set(e.form,"username",r.target.value)}}}),e.$v.form.username.$dirty?t("div",{staticClass:"field-error"},[e.$v.form.username.required?e._e():t("div",{staticClass:"error"},[e._v("Username is required")]),e.$v.form.username.alphaNum?e._e():t("div",{staticClass:"error"},[e._v("Username can only contain letters and numbers")]),e.$v.form.username.minLength?e._e():t("div",{staticClass:"error"},[e._v("Username must have at least "+e._s(e.$v.form.username.$params.minLength.min)+" letters.")]),e.$v.form.username.maxLength?e._e():t("div",{staticClass:"error"},[e._v("Username is too long. It can contains maximium "+e._s(e.$v.form.username.$params.maxLength.max)+" letters.")])]):e._e()]),t("div",{staticClass:"form-group"},[t("label",{attrs:{for:"emailAddress"}},[e._v("Email address")]),t("input",{directives:[{name:"model",rawName:"v-model",value:e.form.emailAddress,expression:"form.emailAddress"}],staticClass:"form-control",attrs:{type:"email",id:"emailAddress"},domProps:{value:e.form.emailAddress},on:{input:function(r){r.target.composing||e.$set(e.form,"emailAddress",r.target.value)}}}),e.$v.form.emailAddress.$dirty?t("div",{staticClass:"field-error"},[e.$v.form.emailAddress.required?e._e():t("div",{staticClass:"error"},[e._v("Email address is required")]),e.$v.form.emailAddress.email?e._e():t("div",{staticClass:"error"},[e._v("This is not a valid email address")]),e.$v.form.emailAddress.maxLength?e._e():t("div",{staticClass:"error"},[e._v("Email address is too long. It can contains maximium "+e._s(e.$v.form.emailAddress.$params.maxLength.max)+" letters.")])]):e._e()]),t("div",{staticClass:"form-group"},[t("label",{attrs:{for:"password"}},[e._v("Password")]),t("input",{directives:[{name:"model",rawName:"v-model",value:e.form.password,expression:"form.password"}],staticClass:"form-control",attrs:{type:"password",id:"password"},domProps:{value:e.form.password},on:{input:function(r){r.target.composing||e.$set(e.form,"password",r.target.value)}}}),e.$v.form.password.$dirty?t("div",{staticClass:"field-error"},[e.$v.form.password.required?e._e():t("div",{staticClass:"error"},[e._v("Password is required")]),e.$v.form.password.minLength?e._e():t("div",{staticClass:"error"},[e._v("Password is too short. It can contains at least "+e._s(e.$v.form.password.$params.minLength.min)+" letters.")]),e.$v.form.password.maxLength?e._e():t("div",{staticClass:"error"},[e._v("Password is too long. It can contains maximium "+e._s(e.$v.form.password.$params.maxLength.max)+" letters.")])]):e._e()]),t("button",{staticClass:"btn btn-primary btn-block",attrs:{type:"submit"}},[e._v("Create account")]),e._m(0),e._m(1)])],1)]),t("PageFooter")],1)},J=[function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("p",{staticClass:"accept-terms text-muted"},[e._v("\n          By clicking “Create account”, you agree to our\n          "),t("a",{attrs:{href:"#"}},[e._v("terms of service")]),e._v(" and\n          "),t("a",{attrs:{href:"#"}},[e._v("privacy policy")]),e._v(".\n        ")])},function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("p",{staticClass:"text-center text-muted"},[e._v("\n          Already have an account?\n          "),t("a",{attrs:{href:"/login"}},[e._v("Sign in")])])}],z={register:function(e){return new Promise(function(r,t){C.a.post("/registrations",e).then(function(e){var t=e.data;r(t)}).catch(function(e){t(P.parse(e))})})}},G={name:"RegisterPage",data:function(){return{form:{username:"",emailAddress:"",password:""},errorMessage:""}},components:{Logo:M,PageFooter:R},validations:{form:{username:{required:w["required"],minLength:Object(w["minLength"])(2),maxLength:Object(w["maxLength"])(50),alphaNum:w["alphaNum"]},emailAddress:{required:w["required"],email:w["email"],maxLength:Object(w["maxLength"])(100)},password:{required:w["required"],minLength:Object(w["minLength"])(6),maxLength:Object(w["maxLength"])(30)}}},methods:{submitForm:function(){var e=this;this.$v.$touch(),this.$v.$invalid||z.register(this.form).then(function(){e.$router.push({name:"login"})}).catch(function(r){e.errorMessage="Failed to register user. "+r.message})}}},K=G,Q=(t("6033"),Object(m["a"])(K,B,J,!1,null,"1216c8a8",null)),V=Q.exports;s["a"].use(c["a"]);var W=new c["a"]({mode:"history",base:"/",routes:[{path:"/",name:"home",component:h},{path:"/login",name:"login",component:H},{path:"/register",name:"register",component:V}]}),X=t("2f62");s["a"].use(X["a"]);var Y=new X["a"].Store({state:{},mutations:{},actions:{}}),Z=t("1dce"),ee=t.n(Z);s["a"].use(ee.a),s["a"].config.productionTip=!1,new s["a"]({router:W,store:Y,render:function(e){return e(u)}}).$mount("#app"),C.a.defaults.baseURL="/api",C.a.defaults.headers.common.Accept="application/json",C.a.interceptors.response.use(function(e){return e},function(e){return Promise.reject(e)})},"5c0b":function(e,r,t){"use strict";var s=t("5e27"),a=t.n(s);a.a},"5e27":function(e,r,t){},6033:function(e,r,t){"use strict";var s=t("30eb"),a=t.n(s);a.a},"648a":function(e,r,t){},8911:function(e,r,t){"use strict";var s=t("648a"),a=t.n(s);a.a},a71d:function(e,r,t){},c556:function(e,r,t){"use strict";var s=t("a71d"),a=t.n(s);a.a},ef76:function(e,r,t){}});
//# sourceMappingURL=app.26d06f8f.js.map