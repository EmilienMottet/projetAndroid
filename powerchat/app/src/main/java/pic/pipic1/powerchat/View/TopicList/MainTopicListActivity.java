package pic.pipic1.powerchat.View.TopicList;

import com.firebase.client.Firebase;
import com.firebase.ui.auth.core.FirebaseLoginBaseActivity;
import com.firebase.ui.auth.core.FirebaseLoginError;
/**
 * Created by emimo on 12/03/2016.
 */
public class MainTopicListActivity extends FirebaseLoginBaseActivity{
    @Override
    protected Firebase getFirebaseRef() {
        return null;
    }

    @Override
    protected void onFirebaseLoginProviderError(FirebaseLoginError firebaseLoginError) {

    }

    @Override
    protected void onFirebaseLoginUserError(FirebaseLoginError firebaseLoginError) {

    }
}
