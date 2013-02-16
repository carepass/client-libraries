# CarePass API for Android

This is a simple API for connecting to CarePass. Currently,
it is focused on the [CarePass OAuth flow](https://developer.carepass.com/docs/carepass/)
and is otherwise very lightweight.

To use it, include the `InitFragment` in an activity you wish to 
authorize. The user may use this to initiate a login. 


## Strings to Set

When the fragment is created, you can use the `set` methods to configure its parameters.
For example, use `setRequestedScope` to change what the requested configuration.

If you are not creating the fragment dynamically, you may configure the following strings in your `res/values` folder:

 * `carepass_api_key` must be the generated key you received when
   you registered your application at the CarePass developer site.
 * `carepass_shared_secret` is the corresponding client code.
 * `carepass_redirect_uri` must be the exact redirect URI you have
   specified for your application.

## Returned value

The auth token and its expected expiration time are stored in shared preferences.

 * `com.aetna.carepass.android.AccessToken` - the access token, stored as a `String`.
 * `com.aetna.carepass.android.AccessTokenExpiry` - the expected exipration time, stored
   as a `long`, as computed with `System.currentTimeMillis()`.

You may also register an `AuthResponseHandler` with the `InitFragment` to get more
control over the response. 
