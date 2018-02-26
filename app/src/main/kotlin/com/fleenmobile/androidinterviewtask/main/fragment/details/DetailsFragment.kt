package com.fleenmobile.androidinterviewtask.main.fragment.details

import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import com.fleenmobile.androidinterviewtask.BaseFragment
import com.fleenmobile.androidinterviewtask.R
import com.fleenmobile.androidinterviewtask.data.User
import com.fleenmobile.androidinterviewtask.showToast
import com.fleenmobile.androidinterviewtask.utils.resourceprovider.ResourceProvider
import com.squareup.picasso.Picasso
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

/**
 * @author FleenMobile at 2018-02-25
 */
class DetailsFragment : BaseFragment<DetailsFragmentContract.Presenter>(),
        DetailsFragmentContract.View, DetailsFragmentContract.Router {

    companion object {
        private val DATE_FORMAT = DateTimeFormat.forPattern("dd/MM/yyyy")
    }

    @BindView(R.id.details_fragment_username)
    lateinit var usernameTextView: TextView

    @BindView(R.id.details_fragment_avatar)
    lateinit var avatarImageView: ImageView

    @BindView(R.id.details_fragment_reputation)
    lateinit var reputationTextView: TextView

    @BindView(R.id.details_fragment_gold_badges_count)
    lateinit var goldBadgesTextView: TextView

    @BindView(R.id.details_fragment_silver_badges_count)
    lateinit var silverBadgesTextView: TextView

    @BindView(R.id.details_fragment_bronze_badges_count)
    lateinit var bronzeBadgesTextView: TextView

    @BindView(R.id.details_fragment_user_location)
    lateinit var locationTextView: TextView

    @BindView(R.id.details_fragment_user_age)
    lateinit var ageTextView: TextView

    @BindView(R.id.details_fragment_user_creation_date)
    lateinit var creationDateTextView: TextView

    @Inject
    lateinit var resourceProvider: ResourceProvider

    override val layoutId: Int = R.layout.fragment_details

    override fun showUser(user: User) = with(user) {
        Picasso
                .with(activity)
                .apply { isLoggingEnabled = true }
                .load(profileImageUrl)
                .into(avatarImageView)

        usernameTextView.text = name
        reputationTextView.text = resourceProvider.getString(R.string.reputation, "$reputation")
        goldBadgesTextView.text = "${badgeCounts.gold}"
        silverBadgesTextView.text = "${badgeCounts.silver}"
        bronzeBadgesTextView.text = "${badgeCounts.bronze}"
        locationTextView.text = location
        ageTextView.text = "$age"
        creationDateTextView.text = DATE_FORMAT.print(creationDate)
    }

    override fun showError(message: String) {
        activity.showToast(message)
    }
}