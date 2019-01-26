package scripts.dax_api;

import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.DaxCredentials;
import scripts.dax_api.api_lib.models.DaxCredentialsProvider;

public class dax_auth
{
    public static void dax_auth()
    {
        DaxWalker.setCredentials(new DaxCredentialsProvider()
        {
            public DaxCredentials getDaxCredentials()
            {
                return new DaxCredentials("sub_DPjcfqN4YkIxm8", "PUBLIC-KEY");
            }
        });
        
    }
}
