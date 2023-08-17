import React, { useState } from "react";

function Location({ companyState }) {
    const [location, setLocation] = useState({});

    return (
        <div className="location">

            <input
                onChange={(e) => {
                    companyState.setCompany({
                        ...companyState.company,
                        location: { ...companyState.company.location, street: e.target.value }
                    });
                    setLocation({...location, street: e.target.value});
                }
                }
                class="form-control form-control-sm" type="text" placeholder="Street"
            />

            <input
                onChange={(e) => {
                    companyState.setCompany({
                        ...companyState.company,
                        location: { ...companyState.company.location, city: e.target.value }
                    });
                    setLocation({...location, city: e.target.value})
                }
                }
                class="form-control form-control-sm" type="text" placeholder="City"
            />

            <div className="rowFlex">

                <input
                    onChange={(e) => {
                        companyState.setCompany({
                            ...companyState.company,
                            location: { ...companyState.company.location, state: e.target.value }
                        });
                        setLocation({...location, state: e.target.value});
                    }
                    }
                    class="form-control form-control-sm" type="text" placeholder="State"
                />

                <input
                    onChange={(e) => {
                        companyState.setCompany({
                            ...companyState.company,
                            location: { ...companyState.company.location, zipCode: e.target.value }
                        });
                        setLocation({...location, zipCode: e.target.value});
                    }
                    }
                    class="form-control form-control-sm" type="number" placeholder="Zip Code"
                />

            </div>
        </div>
    );
}

export default Location;
