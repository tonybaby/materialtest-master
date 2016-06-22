package materialtest.vivz.slidenerd.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import materialtest.vivz.slidenerd.anim.AnimationUtils;
import materialtest.vivz.slidenerd.extras.StoreDetailsTaxiServices;
import materialtest.vivz.slidenerd.materialtest.R;

/**
 * Created by HP on 3/18/2016.
 */
public class TaxiServicesAdapterEcomonical extends RecyclerView.Adapter<TaxiServicesAdapterEcomonical.ViewHolder> {



    private Context context;

    //List to store all
    public static List<StoreDetailsTaxiServices> Details;

    private int mPreviousPosition = 0;

    //Constructor of this class
    public TaxiServicesAdapterEcomonical(List<StoreDetailsTaxiServices> Details, Context context){
        super();
        //Getting all
        this.Details = Details;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.taxi_services_list_element, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //Getting the particular item from the list
        StoreDetailsTaxiServices storeDetailsTaxiServices =  Details.get(position);
//
//
//
//        Uri uri = Uri.parse("http://" + context.getString(R.string.ip) + "/keralaTourism/images/" + storeDetailsTaxiServices.getImageName());
//        String urlAdd = "http://" + context.getString(R.string.ip) + "/keralaTourism/images/" + storeDetailsTaxiServices.getImageName();
//        //Log.i("tonym", urlAdd);
//        Context context = holder.imageViewName.getContext();
//        Picasso.with(context)
//                .load(uri)
//                .resize(250, 250)
//                .into(holder.imageViewName);

//
        holder.textViewVehicleType.setText(storeDetailsTaxiServices.getVehicleType());
        holder.textViewSeatingCapacity.setText(storeDetailsTaxiServices.getSeatingCapacity());
        holder.textViewRatePerDay.setText(storeDetailsTaxiServices.getRatePerDay());
        holder.textViewRatePerExtraKm.setText(storeDetailsTaxiServices.getRatePerAdditionalKm());
        holder.textViewAllowedKmPerDay.setText(storeDetailsTaxiServices.getAllowedKmPerDay());

        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animateSunblind(holder, true);
//            AnimationUtils.animate1(holder, true);
//            AnimationUtils.animate(holder,true);
        } else {
            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animateSunblind(holder, false);
//            AnimationUtils.animate1(holder, false);
//            AnimationUtils.animate(holder, false);
        }
        mPreviousPosition = position;

    }

    @Override
    public int getItemCount() {
        return Details == null ? 0 : Details.size();
//        return Details.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //Views
        public ImageView imageViewName;

        public TextView textViewVehicleType;
        public TextView textViewSeatingCapacity;
        public TextView textViewRatePerDay;
        public TextView textViewRatePerExtraKm;
        public TextView textViewAllowedKmPerDay;

        //Initializing Views
        public ViewHolder(View itemView) {
            super(itemView);
//            imageViewName = (ImageView) itemView.findViewById(R.id.imageViewName);
//           // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//
            textViewVehicleType = (TextView) itemView.findViewById(R.id.textViewVehicleType);
            textViewSeatingCapacity = (TextView) itemView.findViewById(R.id.textViewSeatingCapacity);
            textViewRatePerDay = (TextView) itemView.findViewById(R.id.textViewRatePerDay);
            textViewRatePerExtraKm = (TextView) itemView.findViewById(R.id.textViewratePerExtraKm);
            textViewAllowedKmPerDay = (TextView) itemView.findViewById(R.id.textViewAllowedKmPerDay);
        }
    }
}
