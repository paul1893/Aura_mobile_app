/*
Aura Mobile Application
Copyright (C) 2017 Aura Healthcare

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/
*/

package com.wearablesensor.aura.seizure_report;

import com.wearablesensor.aura.utils.BasePresenter;
import com.wearablesensor.aura.utils.BaseView;

import java.util.Date;


public class SeizureReportContract {

    public interface View extends BaseView<Presenter> {


        void setPresenter(Presenter iPresenter);

        void displaySaveSeizureValidation();
    }


    public interface Presenter extends BasePresenter {
        void giveAdditionalInformationOnSeizure();

        void nextAdditionalInformationSeizureOnSeizure(int iIndex);

        void cancelReportSeizure();

        void reportSeizure();

        void setCurrentDate(Date iDate);

        void setCurrentIntensity(String iIntensity);

        void setQuestionResult(String iQuestionTag, String iResultTag);
    }
}

