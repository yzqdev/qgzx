import colors from "vuetify/es5/util/colors";

export default {

  // buildDir: "qgzx_web",
  target: 'static',
  server: {
    port: 4400, // default: 3000
    host: "0.0.0.0" // default: localhost
  },
  /*
   ** Headers of the page
   */
  head: {
    titleTemplate: "%s - " + "找工作",
    title: "找工作" || "",
    meta: [
      {charset: "utf-8"},
      {name: "viewport", content: "width=device-width, initial-scale=1"},
      {
        hid: "description",
        name: "description",
        content: process.env.npm_package_description || ""
      }
    ],
    link: [{rel: "icon", type: "image/x-icon", href: "/favicon.ico"}]
  },
  /*
   ** Customize the progress-bar color
   */
  loading: {color: "#fff"},
  /*
   ** Global CSS
   */
  css: [],
  /*
   ** Plugins to load before mounting the App
   */

  /*
   ** Nuxt.js dev-modules
   */
  buildModules: ["@nuxtjs/vuetify"],
  /*
   ** Nuxt.js modules
   */
  modules: [
    // Doc: https://axios.nuxtjs.org/usage
    "@nuxt/http",
    "@nuxtjs/pwa",
    // Doc: https://github.com/nuxt-community/dotenv-module
  ],
  http: {
    baseURL: 'http://localhost:8400'
  },
  plugins: [],
  /*
   ** Axios module configuration
   ** See https://axios.nuxtjs.org/options
   */
  /*
   ** vuetify module configuration
   ** https://github.com/nuxt-community/vuetify-module
   */
  vuetify: {
    customVariables: ["~/assets/variables.scss"],
    theme: {
      dark: true,
      themes: {
        dark: {
          primary: colors.blue.darken2,
          accent: colors.grey.darken3,
          secondary: colors.amber.darken3,
          info: colors.teal.lighten1,
          warning: colors.amber.base,
          error: colors.deepOrange.accent4,
          success: colors.green.accent3
        }
      }
    }
  },
  /*
   ** Build configuration
   */
  build: {
    /*
     ** You can extend webpack config here
     */
    extend(config, ctx) {
    }
  }
};
